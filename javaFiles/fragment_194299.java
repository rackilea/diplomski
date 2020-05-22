java -jar spring-boot-app.jar &
app_pid=$!

server_address='http://localhost:8080'
try_time=60
try_count=0
 until $(curl --output /dev/null --silent --head --fail $server_address); do
    try_count=$((try_count+1))
    echo "|${try_count}>"
    sleep 10
    if (( try_count > try_time )); then
        echo "Could not connect to server"
        exit 1
    fi
done
echo "Server available"