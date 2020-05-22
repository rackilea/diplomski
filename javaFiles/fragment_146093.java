invLineItems.get('INV-Error_Test2').each{ 
        print "LINE = "+ it['LINE']
        print " "+" INVOICE_DATE = "+it['INVOICE_DATE']
        print " "+" INVOICE_TOTAL  = "+it['INVOICE_TOTAL']
        println ""
}