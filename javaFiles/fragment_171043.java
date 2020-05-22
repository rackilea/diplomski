#set($name = "")
#set($buffer = [])

#foreach ($employee in $employees)
    #if($velocityCount == 1)
        #set($name = $employee.name)
    #end

    #if($name != $employee.name)
        <br>name($buffer.size())
        #foreach ($attendance in $buffer)
            <br>$attendance
        #end
        <br>&nbsp;

        #set($name = $employee.name)
        #set($buffer = [])
    #else
        #if($buffer.add($employee.attendance))#end
    #end
#end