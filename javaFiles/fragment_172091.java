<rich:fileUpload id="fileUploadComp"
                 addLabel="Agregar" clearAllLabel="Quitar todos"
                 clearLabel="Quitar" deleteLabel="Quitar"
                 doneLabel="Completado" uploadLabel="Subir archivos"
                 fileUploadListener="#{uploadBean.doUpload}"
                 acceptedTypes="txt, csv" onclear="onclear(event);"
                 ontyperejected="ontyperejected();"
                 noDuplicate="true">
    <a4j:ajax event="uploadcomplete" render="validationButton"/>
</rich:fileUpload>

<a4j:jsFunction name="ontyperejected" actionListener="#{uploadBean.setMessage()}"/>

<rich:notifyMessage stayTime="2000" nonblocking="true"/>