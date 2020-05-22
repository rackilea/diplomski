case 131:
                        try {
                            switch ( dti_category_ids.get( 2 ) ) {
                               case 252: // Colleges: Bulls ..snip..
                               case 253: // Colleges: Bulls ..snip..
                               case 254: // Colleges: Bulls ..snip..
                               default: // Log all others to the "College" section
                            }
                            break;
                        // HERE ... THERE'S NO } TO CLOSE THE try {
                        catch ( NumberFormatException e ) {
                            // Log all others to the "College" section
                            site_catalyst_categories = addElements(
                                    dti_category_ids.get( 0 ), "Sports",
                                    "", "College",
                                    "", "",
                                    "", ""
                                );

                        }