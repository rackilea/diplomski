if (i == 0) { 
        Integer codigo = Integer.parseInt(tabelaImoveis.getValueAt(linha, 0).toString());
        for (Imovel imovel : imovelLista) { 
            if (imovel.getCodigo() == codigo) {                               
                frmAlterar alterar = new frmAlterar();  // *** this should be a modal JDialog
                alterar.setLocationRelativeTo(null); 
                // alterar.setVisible(true);
                // alterar.setDefaultCloseOperation(alterar.DISPOSE_ON_CLOSE);
                alterar.setarAtributos(imovel);
                alterar.setVisible(true);
            }
        }
    }