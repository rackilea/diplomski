foo
Nov 28, 2016 3:09:53 PM so.test2.SOTest2 main
SEVERE: null
com.ctc.wstx.exc.WstxValidationException: Element <bar> has no attribute "blah"
 at [row,col {unknown-source}]: [5,5]
    at com.ctc.wstx.exc.WstxValidationException.create(WstxValidationException.java:50)
    at com.ctc.wstx.sr.StreamScanner.reportValidationProblem(StreamScanner.java:580)
    at com.ctc.wstx.sr.ValidatingStreamReader.reportValidationProblem(ValidatingStreamReader.java:383)
    at com.ctc.wstx.sr.InputElementStack.reportProblem(InputElementStack.java:849)
    at com.ctc.wstx.dtd.DTDValidatorBase.doReportValidationProblem(DTDValidatorBase.java:497)
    at com.ctc.wstx.dtd.DTDValidatorBase.reportValidationProblem(DTDValidatorBase.java:479)
    at com.ctc.wstx.dtd.DTDValidator.validateAttribute(DTDValidator.java:251)
    at com.ctc.wstx.sr.AttributeCollector.validateAttribute(AttributeCollector.java:729)
    at com.ctc.wstx.sr.InputElementStack.resolveAndValidateElement(InputElementStack.java:535)
    at com.ctc.wstx.sr.BasicStreamReader.handleStartElem(BasicStreamReader.java:3059)
    at com.ctc.wstx.sr.BasicStreamReader.nextFromTree(BasicStreamReader.java:2919)
    at com.ctc.wstx.sr.BasicStreamReader.next(BasicStreamReader.java:1123)
    at so.test2.SOTest2.main(SOTest2.java:56)