public void configure() {
   from("direct:start")
       .loop(2)
       .log("CamelLoopIndex = ${header.CamelLoopIndex}")
       .to("direct:file-iterator")
       .end();

   from("direct:file-iterator")
       .id("file-iterator")
       .log("  in file-iterator")
       .to("direct:read-file-checksum")
       .to("direct:file-unzip");

    from("direct:read-file-checksum")
       .log("    in read-file-checksum");

    from("direct:file-unzip")
       .log("    in direct:file-unzip");
    }
}