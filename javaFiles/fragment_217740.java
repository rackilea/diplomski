String program;
if (Program.isPlatformLinux())
{
    program = "xdg-open";
} else {
    program = "something else";
}

Runtime.getRuntime().exec(new String[]{program, file.getAbsolutePath()});