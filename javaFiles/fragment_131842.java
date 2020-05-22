rule "balancedStaffWeekend"
    when
        $staff: Staff()
        accumulate(
            Shift(
                staff == $staff
                day == Day.WEEKEND);
                $count: count()
            );
        )
    then
        scoreHolder.addSoftConstraintMatch(kcontext, -Math.pow(count, 2));
end