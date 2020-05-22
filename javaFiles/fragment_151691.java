import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.formula.*;
import org.apache.poi.ss.formula.ptg.*;
import org.apache.poi.ss.formula.EvaluationWorkbook.ExternalSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;

import java.io.FileInputStream;

public class ExcelReadExternalReference {
    public static void main(String[] args) throws Exception {

        String filePath = "TestExternalLinks.xlsx";
        // String filePath = "TestExternalLinks.xls";

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));

        EvaluationWorkbook evalWorkbook = null;
        if (workbook instanceof HSSFWorkbook) {
            evalWorkbook = HSSFEvaluationWorkbook.create((HSSFWorkbook) workbook);
        } else if (workbook instanceof XSSFWorkbook) {
            evalWorkbook = XSSFEvaluationWorkbook.create((XSSFWorkbook) workbook);
        }

        Sheet sheet = workbook.getSheetAt(0);
        EvaluationSheet evalSheet = evalWorkbook.getSheet(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.FORMULA) {
                    String cellFormula = cell.getCellFormula();
                    System.out.println(cellFormula);

                    EvaluationCell evaluationCell = evalSheet.getCell(cell.getRowIndex(), cell.getColumnIndex());
                    Ptg[] formulaTokens = evalWorkbook.getFormulaTokens(evaluationCell);
                    for (Ptg formulaToken : formulaTokens) {
                        int externalSheetIndex = -1;
                        if (formulaToken instanceof Ref3DPtg) {
                            Ref3DPtg refToken = (Ref3DPtg) formulaToken;
                            externalSheetIndex = refToken.getExternSheetIndex();
                        } else if (formulaToken instanceof Area3DPtg) {
                            Area3DPtg refToken = (Area3DPtg) formulaToken;
                            externalSheetIndex = refToken.getExternSheetIndex();
                        } else if (formulaToken instanceof Ref3DPxg) {
                            Ref3DPxg refToken = (Ref3DPxg) formulaToken;
                            externalSheetIndex = refToken.getExternalWorkbookNumber();
                        } else if (formulaToken instanceof Area3DPxg) {
                            Area3DPxg refToken = (Area3DPxg) formulaToken;
                            externalSheetIndex = refToken.getExternalWorkbookNumber();
                        }

                        if (externalSheetIndex >= 0) {
                            System.out.print("We have extrenal sheet index: " + externalSheetIndex
                                    + ". So this formula refers an external sheet in workbook: ");

                            ExternalSheet externalSheet = null;
                            if (workbook instanceof HSSFWorkbook) {
                                externalSheet = evalWorkbook.getExternalSheet(externalSheetIndex);
                            } else if (workbook instanceof XSSFWorkbook) {
                                externalSheet = evalWorkbook.getExternalSheet(null, null, externalSheetIndex);
                            }
                            String linkedFileName = externalSheet.getWorkbookName();
                            System.out.println(linkedFileName);

                        }
                    }
                }
            }
        }

        workbook.close();
    }

}