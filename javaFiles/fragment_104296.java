task :some_name do
     puts "==================Building with Maven======================"
     run "cd #{deploy_to}/current && mvn clean package"
     run "nohup java -jar #{deploy_to}/current/target/*dependencies.jar > /dev/null 2>&1 &"
  end

  after "deploy", "some_name"