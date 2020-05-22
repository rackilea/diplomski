# cf. https://github.com/mozilla/emr-bootstrap-presto/blob/master/files/bootstrap/presto-plugins.sh
#!/bin/bash

set -exo pipefail

# re-exec with sudo into background
if [ $(whoami) != root ]; then
  sudo "$0" "$@" &
  exit 0
fi

# set variables
s3uri=$1
fluentd_endpoint=$2

# wait until presto is installed and running
until test -s /var/run/presto/presto-server.pid; do sleep 1; done

# make symbolic link
sudo mkdir -p /usr/lib/presto/etc 2>/dev/null
sudo ln -s /usr/lib/presto/etc /mnt/var/lib/presto/data

# download presto plugins
aws s3 sync $s3uri/jar/ /usr/lib/presto/plugin/
aws s3 sync $s3uri/properties /usr/lib/presto/etc/

# make sure all plugins are owned by presto user
chown -R presto:presto /usr/lib/presto/plugin
chown -R presto:presto /usr/lib/presto/etc

# set event-listner.properties endpoint parameter
echo "event-listener.fluentd-host=$fluentd_endpoint" >> 
/usr/lib/presto/etc/event-listener.properties

# restart presto
stop  presto-server
start presto-server