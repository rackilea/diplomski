#!/bin/sh                                                                                                                                   

echo "Installing IntelliJ IDEA..."

# We need root to install
[ $(id -u) != "0" ] && exec sudo "$0" "$@"

# define version (ultimate. change to 'C' for Community)
ed='U'

# Fetch the most recent community edition URL
URL=$(wget "https://www.jetbrains.com/idea/download/download_thanks.jsp?edition=I${ed}&os=linux" -qO- | grep -o -m 1 "https://download.jetbrains.com/idea/.*gz")

echo "URL: ${URL}"
echo "basename(url): $(basename ${URL})"

# Truncate filename
FILE=$(basename ${URL})

echo "File: ${FILE}"

# Download binary
wget -cO /tmp/${FILE} ${URL} --read-timeout=5 --tries=0

# Set directory name
DIR="${FILE%\.tar\.gz}"

# Untar file
if mkdir /opt/${DIR}; then
    tar -xvzf /tmp/${FILE} -C /opt/${DIR} --strip-components=1
fi

# Grab executable folder
BIN="/opt/$DIR/bin"

# Add permissions to install directory
chmod 755 ${BIN}/idea.sh

# Set desktop shortcut path
DESK=/usr/share/applications/IDEA.desktop

# Add desktop shortcut                     
echo -e "[Desktop Entry]\nEncoding=UTF-8\nName=IntelliJ IDEA\nComment=IntelliJ IDEA\nExec=${BIN}/idea.sh\nIcon=${BIN}/idea.png\nTerminal=false\nStartupNotify=true\nType=Application" > ${DESK}

echo "Done."