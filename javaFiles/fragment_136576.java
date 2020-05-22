ResultSet rs1 = stmt.executeQuery("CREATE OR REPLACE TRIGGER test_trigger123\n"+
                "BEFORE INSERT ON RESULTS\n"+
                "REFERENCING NEW AS NEW\n"+
                "FOR EACH ROW\n"+
                "BEGIN\n"+
                "SELECT Pd_seq.nextval INTO :NEW.PT_ID FROM dual;\n"+
                "END;\n"+
                "\n/");