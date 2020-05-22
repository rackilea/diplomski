require 'zip/zip'

filename = 'class_file.class'

Zip::ZipOutputStream::open "jar_file.jar" do |zip|
  zip.put_next_entry 'dest/path/in/jar/' + filename  # don't forget the path

  File.open filename, 'rb' {|f| zip.write f.read }
end