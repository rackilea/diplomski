{
  "package-name": "net.company.demo",
  "xml-schema": {
    "element-form-default": "QUALIFIED",
    "namespace": "http://www.example.com/customer"
  },
  "java-types": {
    "java-type": {
      "name": "Pojo",
      "xml-virtual-access-methods": {
        "get-method": "get",
        "set-method": "set"
      },
      "xml-root-element": {
        "name": "rootElement"
      },
      "java-attributes": {
        "xml-element": {
          "java-attribute": "message",
          "type": "java.lang.String",
          "xml-path": "/params/parameter[@name='message']/text()"
        },
        "xml-element": {
          "java-attribute": "shouldValidate",
          "type": "java.lang.String",
          "xml-path": "/params/parameter[@name='validate']/text()"
        },
        "xml-element": {
          "java-attribute": "buffer",
          "type": "java.lang.String",
          "xml-path": "/params/parameter[@name='buffer']/text()"
        }
      }
    }
  }
}