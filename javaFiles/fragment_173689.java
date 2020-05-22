package com.awzpact.prayas.service;

import com.awzpact.prayas.dao.HRMSPickSalaryDataDAO;
import com.awzpact.uam.domain.SalaryDetailReport;
import com.awzpact.uam.domain.Userdetail;
import com.awzpact.uam.exceptions.MyExceptionHandler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author jack
 */
@Service
public class NewPayrollService {

    final TransactionDefinition erpTxnDefination = new DefaultTransactionDefinition();
    final TransactionDefinition prayasTxnDefination = new DefaultTransactionDefinition();
    final int BATCH_SIZE = 500;

    public void getSalarayData(final String yearMonth, final String regionId, final String circleId, final Userdetail loginUser) {
        final String tableSuffix = yearMonth.substring(4, 6) + yearMonth.substring(0, 4);
        final TransactionStatus erpTransaction = erpTransactionManager.getTransaction(erpTxnDefination);
        try {
            List<SalaryDetailReport> list = hRMSPickSalaryDataDAO.findAll(yearMonth, regionId, circleId);
        } catch (Exception e) {
        }
        final TransactionStatus prayasTransaction = prayasTransactionManager.getTransaction(prayasTxnDefination);

    }

    @Autowired
    @Qualifier("oldOne")
    DataSourceTransactionManager prayasTransactionManager;


    @Autowired
    @Qualifier("newOne")
    DataSourceTransactionManager erpTransactionManager;

    @Autowired
    HRMSPickSalaryDataDAO hRMSPickSalaryDataDAO;
}