String           dateIdValue   = "...";
Class<?>         mainClass     = A.class;
Class<?>         dateClass     = B.class;

String           colDate1      = "date1";
String           colDate2      = "date2";
String           colDateId     = "id";

Property         date1Prop     = Property.forName(colDate1);
Property         date2Prop     = Property.forName(colDate2);

DetachedCriteria date1Criteria = DetachedCriteria.forClass(dateClass)
                                                 .setProjection(date1Prop)
                                                 .add(Restrictions.eq(colDateId, dateIdValue));
DetachedCriteria date2Criteria = DetachedCriteria.forClass(dateClass)
                                                 .setProjection(date2Prop)
                                                 .add(Restrictions.eq(colDateId, dateIdValue));

Criteria         criteria      = getSession().createCriteria(mainClass)
                                .add(date1Prop.lt(date1Criteria))
                                .add(Restrictions.or(date2Prop.isNull(), date2Prop.le(date2Criteria)))
                                .addOrder(Order.desc("x"));

/*
    SELECT A.*
    FROM   A, P
    WHERE  A.date1 < P.date1
    AND   (A.date2 is null or A.date2 <= P.date2 )
    ORDER BY A.x DESC;
 */