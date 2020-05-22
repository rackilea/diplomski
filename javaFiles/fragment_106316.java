List<Shapes> allShapes = shapesDao.getAllShapes();
        for (Shapes shapeobj : allShapes)
        {
            if(shapeobj.getShapeId() == id)
            {
                formula = shapeobj.getShapeFormula();
            }
        }
        final JexlEngine jexl = new 

    JexlBuilder().cache(512).strict(true).silent(false).create();
            String jexlExp = formula;

            JexlExpression  e = jexl.createExpression(formula);
            JexlContext context = new MapContext();
            for(int i = 0; i<params; i++)
            {
                for(int j=0;j<completed.length;j++)
                {
                    System.out.println("-------------------------");
                    System.out.println(completed[j]);
                    System.out.println("-------------------------");
                    context.set(completed[j], request.getParameter(completed[j]));
                }
            }


            Object o = e.evaluate(context);