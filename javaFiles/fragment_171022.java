// Constructs the system class path (aka boot class path) from the following
// components, in order:
//
//     prefix           // from -Xbootclasspath/p:...
//     endorsed         // the expansion of -Djava.endorsed.dirs=...
//     base             // from os::get_system_properties() or -Xbootclasspath=
//     suffix           // from -Xbootclasspath/a:...
//
// java.endorsed.dirs is a list of directories; any jar or zip files in the
// directories are added to the sysclasspath just before the base.