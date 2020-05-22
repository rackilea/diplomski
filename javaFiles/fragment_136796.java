if [ ! "$upgrade_file_path" = "" ]; then
    echo "BUILD SUCCESS"
    echo "upgrade.cpio.gz : "$upgrade_file_path
    //Here you can just add something like:
    exit 0;
else
    echo "FAILED TO CREATE upgrade.cpio.gz"
    exit 1;
fi