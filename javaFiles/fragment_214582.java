int endTask = 0;
                            int currDuration = 0;
                            String currTaskOut = "";
                            if (rs1.getLong("columnName") <= curTime) {
                                //if (rs.getLong("columnName") > ...) {
                                endTask = ...;
                                currDuration = ...;
                            } else {
                                //...
                            }
                            pst2.setLong(13, endTask);
                            pst2.setLong(14, currDuration);
                            pst2.setString(15, currTaskOut);
                            pst2.setInt(16, loop);