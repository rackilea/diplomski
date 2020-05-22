{
  "cmd": ["javac", "$file_name","&&","java", "$file_base_name"],
  "working_dir": "${project_path:${folder}}",
  "selector": "source.java",
  "shell": true
}