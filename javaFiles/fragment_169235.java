pkill elenium
pkill java
pkill ios_webkit_debug_proxy
pkill node

java -jar ../libs/selenium-server-standalone-2.46.0.jar -role hub -port 4444 > logs/log_hub.txt 2>&1 &
if [ $? = 1 ]; then
    echo hub
    exit 1
fi

appium --nodeconfig /Path/to/androidOne.json -p 4823 -bp 5724 --chromedriver-port 9515 > logs/log_androidOne.txt &
if [ $? = 1 ]; then
    echo node 1
    exit 1
fi
appium --nodeconfig /Path/to/androidTwo.json -p 4723 -bp 5723 --chromedriver-port 9516 > logs/log_androidTwo.txt &
if [ $? = 1 ]; then
    echo node 2
    exit 1
fi

node appium --session-override --nodeconfig /Path/to/iPod.json --tmp /tmp/ios/ -p 4623 --webkit-debug-proxy-port 27753 --safari > logs/log_iPodTouch.txt &
if [ $? = 1 ]; then
echo node3
exit 1
fi

node appium --session-override --nodeconfig /Path/to/iPad.json --tmp /tmp/ios6/ -p 4523 --webkit-debug-proxy-port 27754 --safari > logs/log_iPad.txt &
if [ $? = 1 ]; then
echo node4
exit 1
fi

sleep 5
REMOTE_DEBUGGER_PORT=27753
./ios-webkit-debug-proxy-launcher.js -c UDID:27753 -d > logs/log_iwdpl.txt &
if [ $? = 1 ]; then
    echo iwdpl
    exit 1
fi
REMOTE_DEBUGGER_PORT=27754
./ios-webkit-debug-proxy-launcher.js -c UDID:27754 -d > logs/log_iwdpl2.txt &
if [ $? = 1 ]; then
echo iwdpl2
exit 1
fi