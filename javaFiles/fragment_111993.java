sql = "SELECT * FROM Tables WHERE"
                            + "( p1Name = 'Empty'" 
                            + " OR p2Name = 'Empty'"
                            + " OR p3Name = 'Empty'"
                            + " OR p4Name = 'Empty'"
                            + " OR p5Name = 'Empty'"
                            + " OR p6Name = 'Empty' )"
                            + " AND tableNumber = '" + minTable + "'";