package com.sree;

import com.sree.test.CreateFile;

public class CreateFileAction {

    private CreateFile file_c;

    public CreateFileAction() {
        System.out.println(" constructor null");
    }

    public CreateFileAction(CreateFile file) {
        System.out.println(" constructor not null");
        this.file_c = file;
    }
}

package com.sree.test;

public class CreateFile {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}