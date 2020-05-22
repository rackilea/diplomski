...
mbeanExporter.registerManagedResource(beanInstance);
...

@Required
public void setMbeanExporter(MBeanExporter mbeanExporter) {
    this.mbeanExporter = mbeanExporter;
}