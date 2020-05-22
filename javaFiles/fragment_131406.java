String[] args = {
    "/bin/sh",
    "-c",
    "ps -e > /home/root/workspace/MyProject/ProcessList.txt"
};
java.lang.Runtime.getRuntime(args);