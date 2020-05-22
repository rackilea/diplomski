rule "Better Test"
when
    $V1: Account( $sta: status, $ins: insurance )
    eval( $sta.equals( "Inactive" ) ||
          $ins != null && $ins.getCurrentInd().equals( "N" ) )
then
    System.out.println("Better Test " + $V1.getId() );
end