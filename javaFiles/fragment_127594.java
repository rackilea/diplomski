Geom.groovy
-------------------
package webservices

import javax.jws.WebService
import javax.jws.soap.SOAPBinding.Style
import javax.jws.soap.SOAPBinding

@WebService
@SOAPBinding(style=Style.RPC)
interface Geom {
    double getArea(double val)
}

Circle.groovy
-------------------
package webservices

import javax.jws.WebService

@WebService(endpointInterface='webservices.Geom')
class Circle implements Geom {
        double getArea(double r) { Math.PI*r*r }
}

publish.groovy
--------------------
package webservices

import javax.xml.ws.Endpoint

Endpoint.publish('http://localhost:5555/circle',new Circle())
println 'ready to receive requests...'