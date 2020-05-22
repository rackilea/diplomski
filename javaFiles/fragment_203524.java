#!/usr/bin/tclsh

proc dereferenceLink {path {tree {}}} {
    if {[file type $path] == "link"} {
        set pointsTo [file link $path]
        if {[lsearch -exact $tree $path] >= 0} {
            lappend tree $path
            return "[join $tree ->] (circular reference)"
        } else {
            lappend tree $path
            return [dereferenceLink $pointsTo $tree]
        }
    } else {
        lappend tree $path
        return [join $tree "->"]
    }
}

puts [dereferenceLink [lindex $argv 0]]