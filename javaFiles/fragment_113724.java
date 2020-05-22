<!-- list of mandatories Sonar properties -->
                <sources>
                     <path location="${src}" />
                </sources>

                <!-- binaries directories, which contain for example the compiled Java bytecode (optional) -->
                <binaries>
                     <path location="${classes.dir}" />
                </binaries>
            </sonar:sonar>

        </target>