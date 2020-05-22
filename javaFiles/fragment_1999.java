<select id="getRecursive" lang="velocity" resultType="int">
    #macro(node $a)
        #if( ! $a.op )
            SELECT sum(val) as val FROM A
            WHERE id = ${a.id} 
        #else
            SELECT
            #if( $a.op == "AND" )
                max(val) as val
            #else
                min(val) as val
            #end
            FROM (
                #repeat( $a.nodes $aNode "UNION ALL" )
                   #node($aNode)
                #end
            )
        #end
    #end

    select val FROM (
        #node($_parameter.A)
    )
</select>