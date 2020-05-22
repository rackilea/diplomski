import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadFile {
    public static void main(String[] args) {
        File content = new File("/home/mohit/file.xlsx");
        try {
            FileInputStream stream = new FileInputStream(content);
            XSSFWorkbook wb = new XSSFWorkbook(stream);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            Iterator rows = sheet.rowIterator();
            int totalIteration = 0;
            String total = "";
            int currentIterationNumber= 0;

            Guest guest = new Guest();
            List<Guest> guestList = new ArrayList<>();
            List<Room> roomList = new ArrayList<>();

            while (rows.hasNext()) {
                totalIteration++;
                currentIterationNumber++;
                int cellIndicator= 0;
                row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                Room room = new Room();

                // Each cell
                while (cells.hasNext()) {
                    cellIndicator++;
//                    System.out.print("\nCurrent CellNo :"+cellIndicator+"    ");
                    cell = (XSSFCell) cells.next();

                    // Get Name and Invoice Number
                    if (currentIterationNumber==1){
                        if (cellIndicator==2){
                            guest.setGuestName(cell.getStringCellValue());
                        }
                        if (cellIndicator == 4){
                            guest.setInvoiceNumber((int) cell.getNumericCellValue());
                        }
                    }
                    // Get ConfirmationNumber and EmailAddress
                    if (currentIterationNumber==2){
                        if (cellIndicator==2){
                            guest.setGuestEmail(cell.getStringCellValue());
                        }
                        if (cellIndicator == 4){
                            guest.setConfirmationNumber((int) cell.getNumericCellValue());
                        }
                    }
                    // Get Address and Arrival Dates
                    if (currentIterationNumber==3){
                        if (cellIndicator==2){
                            guest.setGuestAddress(cell.getStringCellValue());
                        }
                        if (cellIndicator == 4){
                            cell.setCellType(CellType.STRING);
                            guest.setArrivalDate(cell.getStringCellValue());
                        }
                    }
                    // Get and Append Address & Departure date
                    if (currentIterationNumber==4){
                        if (cellIndicator==2){
                            guest.setGuestAddress(guest.getGuestAddress()+", "+cell.getStringCellValue());
                        }
                        if (cellIndicator == 4){
                            cell.setCellType(CellType.STRING);
                            guest.setDepartureDate(cell.getStringCellValue());
                        }
                    }
                    // Get and Append Address & RoomType
                    if (currentIterationNumber==5){
                        if (cellIndicator==2){
                            cell.setCellType(CellType.STRING);
                            guest.setGuestAddress(guest.getGuestAddress()+", "+cell.getStringCellValue());
                        }
                        if (cellIndicator == 4){
                            cell.setCellType(CellType.STRING);
                            guest.setRoomType(cell.getStringCellValue());
                        }
                    }

                    // Get and Append Address & Reference
                    if (currentIterationNumber==6){
                        if (cellIndicator==2){
                            guest.setGuestAddress(guest.getGuestAddress()+", "+cell.getStringCellValue());
                        }
                        if (cellIndicator == 4){
                            cell.setCellType(CellType.STRING);
                            guest.setReference(cell.getStringCellValue());
                        }
                    }

                    // Get Stays Data and map to Room Class
                    if (currentIterationNumber>7) {
//                        System.out.print("Starting Stay..."+cellIndicator);
                        if (cellIndicator == 1) {
                            cell.setCellType(CellType.STRING);
//                            System.out.print("Stay Date:"+cell.getStringCellValue());
                            room.setStayDate(cell.getStringCellValue());
                        }

                        if (cellIndicator == 2) {
//                            System.out.print("   Item:"+cell.getStringCellValue());
                            room.setItem(cell.getStringCellValue());
                        }
                        if (cellIndicator == 3) {
//                            System.out.print("   Quantity:"+cell.getNumericCellValue());
                            room.setQuantity((int) cell.getNumericCellValue());
                        }
                        if (cellIndicator == 4) {
                            if (cell.getCellType() != XSSFCell.CELL_TYPE_STRING) {
//                                System.out.print("   Rate:"+cell.getNumericCellValue());
                                room.setRate((int) cell.getNumericCellValue());
                            }
                        }
                        if (cellIndicator == 5) {
//                            System.out.print("   Amount:"+cell.getNumericCellValue());
                            room.setAmount((int) cell.getNumericCellValue());
//                        System.out.print("\nStayDate: "+room.getStayDate()+"   Item: "+room.getItem()+"    Quantity:  "+room.getQuantity()
//                        +"  Rate: "+room.getRate()+"    Amount:"+room.getAmount()+" \n");
//
                            System.out.print("\nAdding Room to the list");
                            roomList.add(room);
                        }

                    }

                    // Check if Current Row is total row
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        total = cell.getStringCellValue();
                    }

                    // End Collecting for Guest here when you see "Total"
                    if (cellIndicator == 4 && total.equals("Total")){
                        guest.setRoomList(roomList);
                        guestList.add(guest);
                        System.out.print("\nSaving "+guest.getGuestName()+" details with count "+roomList.size());


                        // Perform you DB Operation here

                        // Reset Counter and RoomList
                        guest = new Guest();
                        currentIterationNumber=0;
                        roomList.clear();
                    }
                }

            }

            for (Guest guest1:guestList) {
                System.out.print("\n---- Collected Data: \n Name:"+guest1.getGuestName()+"   InvoiceNo: "+guest1.getInvoiceNumber()
                        +"  Email: "+guest1.getGuestEmail()+"    Confirmation No: "+guest1.getConfirmationNumber()+ "     Address: "+guest1.getGuestAddress()
                        +"   Arrival: "+guest1.getArrivalDate()+"    Dep:"+guest1.getDepartureDate()+"    RoomType: "+guest1.getRoomType()
                        +"      Ref:"+guest1.getReference()+"   Room Count: "+guest1.getRoomList().size());
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}