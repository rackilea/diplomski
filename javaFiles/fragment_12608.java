output  = "/tmp/output.tmp"


execute "publish" do
  Chef::Log.info("About to published")
  command command "java -jar myjar.jar &> #{output}"
  action :run
  Chef::Log.info("Published")
end

# Outputting logs to console
ruby_block "log" do
    block do
        print "\n"
        File.open(output).each do |line|
            print line
        end
    end
end