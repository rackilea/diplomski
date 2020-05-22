(...)
} else if (params[0].equalsIgnoreCase("ro.product.model")) {
    out.println(params[0]+"="+"Galaxy Nexus");
    /**out.println(line); **/
    out.flush();
} else {
    out.println(line);
}
(...)