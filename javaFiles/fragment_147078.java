task zip(type: Zip) {
    from jar.outputs.files
    from('bar/') {
        into('bar')
    }
}