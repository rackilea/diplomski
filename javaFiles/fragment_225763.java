on RunFile(jar_location)
    set pid to do shell script "cd " & jar_location & " ; cat 'prompt.csv' | sh 'runScript.sh' 'WSO' &> /dev/null & echo $!"
    -- wait 5 seconds, or whatever seems appropriate for the task to complete
    delay 5
    try
        do shell script "kill " & pid
    end try
end RunFile