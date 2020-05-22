sudo mkdir /usr/lib/jvm-oracle

sudo cp ~/Downloads/(name of your tarball) /usr/lib/jvm-oracle 

cd /usr/lib/jvm-oracle

sudo tar -xvzf (name of tarball)

cd jdk1.8.0_(corresponding version)

sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm-oracle/jdk1.8.0_{version}/bin/java 1
sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm-oracle/jdk1.8.0_{version}/bin/javac 1
sudo update-alternatives --install /usr/bin/javaws javaws /usr/lib/jvm-oracle/jdk1.8.0_{version}/bin/javaws 1

sudo cat > /etc/profile.d/jdk.sh
export JAVA_HOME="/usr/lib/jvm-oracle/jdk1.8.0_221"
export PATH="$PATH:${JAVA_HOME}/bin"
Ctrl+d