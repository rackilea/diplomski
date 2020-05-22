CREATE OR REPLACE PACKAGE APPS.XX01_CPC_AP_PKG
AS

PROCEDURE XX01_CREATE_INVOICE (P_HF_CODE IN VARCHAR2,
                               P_BATCH_ID IN VARCHAR2,
                               P_AMOUNT IN NUMBER,
                               x_invoice_id OUT NUMBER/*,
                               x_error_code OUT VARCHAR2,
                               x_error_msg  OUT VARCHAR2,
                               x_err_comments OUT VARCHAR2,
                               x_code OUT NUMBER,
                               x_source OUT VARCHAR2*/);

FUNCTION XX01_CREATE_INVOICE_F (P_HF_CODE IN VARCHAR2,
                               P_BATCH_ID IN VARCHAR2,
                               P_AMOUNT IN NUMBER) RETURN NUMBER;