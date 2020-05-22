IloCP cp2 = new IloCP();
            IloIntVar Belgium = cp2.intVar(0, 3);
            IloIntVar Denmark = cp2.intVar(0, 3);
            IloIntVar France = cp2.intVar(0, 3);
            IloIntVar Germany = cp2.intVar(0, 3);
            IloIntVar Luxembourg = cp2.intVar(0, 3);
            IloIntVar Netherlands = cp2.intVar(0, 3);

            cp2.add(cp2.neq(Belgium , France)); 
            cp2.add(cp2.neq(Belgium , Germany)); 
            cp2.add(cp2.neq(Belgium , Netherlands));
            cp2.add(cp2.neq(Belgium , Luxembourg));
            cp2.add(cp2.neq(Denmark , Germany)); 
            cp2.add(cp2.neq(France , Germany)); 
            cp2.add(cp2.neq(France , Luxembourg)); 
            cp2.add(cp2.neq(Germany , Luxembourg));
            cp2.add(cp2.neq(Germany , Netherlands)); 

            cp2.add(cp2.le(cp2.prod(Germany,Germany),4));

            if (cp2.solve())
                {    
                   System.out.println();
                   System.out.println( "Belgium:     " + (int)cp2.getValue(Belgium));
                   System.out.println( "Denmark:     " + (int)cp2.getValue(Denmark));
                   System.out.println( "France:      " + (int)cp2.getValue(France));
                   System.out.println( "Germany:     " + (int)cp2.getValue(Germany));
                   System.out.println( "Luxembourg:  " + (int)cp2.getValue(Luxembourg));
                   System.out.println( "Netherlands: " + (int)cp2.getValue(Netherlands));
                }