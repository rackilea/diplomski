String foAsString = "your_fo_as_string";
File destination = new File("path_to_file"");

BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination));
Driver driver = new Driver(new InputSource(new StringReader(foAsString)), out);
driver.setRenderer(Driver.RENDER_PS);
driver.run();

out.close();

return destination;