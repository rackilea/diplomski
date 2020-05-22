shubuntu1@shubuntu1:~/77$ docker exec 77_frontend_1 cat /etc/profile
export CHARSET=UTF-8
export LANG=C.UTF-8
export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
export PAGER=less
export PS1='\h:\w\$ '
umask 022

for script in /etc/profile.d/*.sh ; do
    if [ -r $script ] ; then
            . $script
    fi
done
echo "hello"