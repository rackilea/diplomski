// -------package section-------
PackageDescr pkg=new PackageDescr();
pkg.setName("com.demo.model");

// -------import section here-------
ImportDescr importEntry1= new ImportDescr();
importEntry1.setTarget("com.demo.model.Purchase");
pkg.addImport(importEntry1);
ImportDescr importEntry2= new ImportDescr();
importEntry2.setTarget("com.demo.model.PotentialCustomer");
pkg.addImport(importEntry2);

ImportDescr importEntry3= new ImportDescr();
importEntry3.setTarget("com.demo.model.PaymentMethod");
pkg.addImport(importEntry3);

//-------global section here-------
GlobalDescr globalEntry=new GlobalDescr();
globalEntry.setType("org.slf4j.Logger");
globalEntry.setIdentifier("logger");
pkg.addGlobal(globalEntry);

//------- rule section here
RuleDescr ruleEntry=new RuleDescr();
ruleEntry.setName("Identify potential customers");

// ------- lhs starts here ------- 
AndDescr lhs=new AndDescr();

//-------  pattern starts here ------- 
PatternDescr patternEntry1=new PatternDescr();
patternEntry1.setIdentifier("$p");
patternEntry1.setObjectType("Purchase");

//------- ExprConstraint starts here ------- 
 ExprConstraintDescr ecd1=new ExprConstraintDescr();
 ecd1.setExpression("paymentMethod");
 ExprConstraintDescr ecd2=new ExprConstraintDescr();
 ecd2.setExpression("PaymentMethod.CASH");
//-------  Added exprConstraint into relational expr------- 
    RelationalExprDescr red1=new RelationalExprDescr("==",false, null, ecd1, ecd2);

    ExprConstraintDescr ecd3=new ExprConstraintDescr();
    ecd3.setExpression("subTotal");
    ExprConstraintDescr ecd4=new ExprConstraintDescr();
    ecd4.setExpression("300");
    RelationalExprDescr red2=new RelationalExprDescr(">",false, null, ecd3, ecd4);


patternEntry1.addConstraint(red1);
patternEntry1.addConstraint(red2);
lhs.addDescr(patternEntry1);

NotDescr notDescr=new NotDescr();
notDescr.setText("not");


PatternDescr pattDescr1=new PatternDescr();
pattDescr1.setObjectType("PotentialCustomer");

ExprConstraintDescr ecd11=new ExprConstraintDescr();
ecd11.setExpression("customerName");
ExprConstraintDescr ecd12=new ExprConstraintDescr();
ecd12.setExpression("$p.getCustomerName()");
RelationalExprDescr red11=new RelationalExprDescr("==",false, null, ecd11,ecd12);
pattDescr1.addConstraint(red11);
notDescr.addDescr(pattDescr1);
lhs.addDescr(notDescr);


ruleEntry.setLhs(lhs);

pkg.addRule(ruleEntry);
String drl = new DrlDumper().dump( pkg );

 // here drl is in form of String