adb reboot bootloader

IMG_PATH="./out/target/product/grouper";

# Erase userdata
fastboot -w

echo Flashing System .. 
fastboot flash system $IMG_PATH/system.img
echo Flashig Boot ... 
fastboot flash boot $IMG_PATH/boot.img
echo Flashin Recovery .. 
fastboot flash recovery $IMG_PATH/recovery.img
echo now rebooting device ...
fastboot reboot