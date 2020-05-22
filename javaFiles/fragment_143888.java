package com.ford.ltdrive.model.output.excel.excelenum;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloneSheet {

    public void backup(String filepath) {
        try {
            Date d = new Date();
            String dateString = (d.getYear() + 1900) + "_" + d.getMonth() + "_" + d.getDate();
           // String backupfilepath = filepath.replace(".xlsm", "_backup_" + dateString + ".xlsm");
            //Path copied = Paths.get(backupfilepath);
            Path copied1 = Paths.get(filepath + "_tmp");
            Path originalPath = Paths.get(filepath);
           // Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(originalPath, copied1, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(Paths.get(filepath));
        } catch (IOException ex) {
            Logger.getLogger(CloneSheet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cloneSheets(String xlsfile, java.util.List<String> list,int copynum) {
        ActiveXComponent app = new ActiveXComponent("Excel.Application");
        try {
            backup(xlsfile);

            app.setProperty("Visible", new Variant(false));
            Dispatch excels = app.getProperty("Workbooks").toDispatch();
            Dispatch excel = Dispatch.invoke(
                    excels,
                    "Open",
                    Dispatch.Method,
                    new Object[]{xlsfile + "_tmp", new Variant(false),
                        new Variant(true)}, new int[1]).toDispatch();
            //Dispatch sheets = Dispatch.get((Dispatch) excel, "Worksheets").toDispatch();
            int sz = list.size();//"Angle_1pc_SBC_R1"
            for (int i = 0; i < sz; i++) {
                Dispatch sheet = Dispatch.invoke(excel, "Worksheets", Dispatch.Get,
                        new Object[]{list.get(i)}, new int[1]).toDispatch();//Whatever sheet you    //wanted the new sheet inserted after

                //Dispatch workbooksTest = app.getProperty("Sheets").toDispatch();//Get the workbook
                //Dispatch sheet2 = Dispatch.call(workbooksTest, "Add").toDispatch();
                for(int k=0;k<copynum -1;k++)
                {
                    Dispatch.call(sheet, "Copy", sheet);
                }
            }
            //Moves the sheet behind the desired sheet
            Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[]{xlsfile, new Variant(52)}, new int[1]);
            Variant f = new Variant(false);
            Dispatch.call(excel, "Close", f);
            Files.delete(Paths.get(xlsfile + "_tmp"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            app.invoke("Quit", new Variant[]{});
        }
    }
   /* public static void main(String args[])
    {
        java.util.ArrayList<String> list = new java.util.ArrayList();
        list.add("Angle_1pc_SBC_R1");
        new CloneSheet().cloneSheets("C:\\LTDrive2_4\\Excel\\Test.xlsm", list, 2);
    }*/
}