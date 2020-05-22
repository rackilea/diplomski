{
     "cmd": ["javac", "$file"],
     "file_regex": "^(...*?):([0-9]*):?([0-9]*)",
     "selector": "source.java",
     "shell": true,

     "variants":
     [
     {
          "name": "Run",
          "cmd": ["start", "cmd", "/k", "java", "$file_base_name"],
          "shell": true
     }
     ]
}