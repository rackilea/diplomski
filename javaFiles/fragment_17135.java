FILES_${PN} += "/lib64/ld-linux-x86-64.so.2"

do_install_append() {
    install -d ${D}/lib64
    cd ${D}/lib64
    ln -s ../lib/ld-2.26.so ld-linux-x86-64.so.2 
}