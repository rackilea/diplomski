when
    $maxAssignment: ShiftAssignment() from accumulate(
        $sa: ShiftAssignment(),        
        init( ShiftAssignment max = null; ),
        action( if( max == null || max.totalWeight < $sa.totalWeight ){
            max = $sa;
        } ),
        result( max ) )
then
    //$maxAssignment contains the ShiftAssignment with the highest weight. 
end