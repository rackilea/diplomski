<if>
    <then>
        <and>
            <available file="${infinys.root}/schema_params/@{componentname}-schema_params.sql" 
                type="file"/>
            <available file="${stage.dir}/@{componentname}/@{installableid}/schema/install/scripts" 
                type="dir"/>
        </and>
        <sequencial>
            ....
        </sequential/>
    </then>
</if>