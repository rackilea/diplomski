<wsimport
        debug="true"
    keep="true"
    verbose="true"
    destdir="${generated.src}"
    package="com.amazon.webservices.ecs"
    wsdl="wsdl/AWSECommerceService.wsdl">

    <binding dir="wsdl" includes="*.jxb"/>

</wsimport>