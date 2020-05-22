rule "Maximum usage of a resource"
       when
             $r : Resource()
             $p : TaskAssignment($id1 : id, $ts : timeSlot != null,
                                 resourceUsage!.ressource==$r,
                                 $usage : resourceUsage!.usagePercent);
             accumulate(TaskAssignment(timeSlot != null, timeSlot <= $ts, 
                                      endingSlot > $ts, id != $id1, 
                                      resourceUsage!.ressource==$r, 
                                      $rate : resourceUsage!.usagePercent);
                                  $s:sum($rate);
                                  $s + $usage > 100) 
       then
             scoreHolder.addHardConstraintMatch(kcontext, 100-($s + $usage));         
end