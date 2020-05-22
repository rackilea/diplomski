public String atuzalizarCadastroCliente(DadosCadastraisSerealizable dados){
        SoapObject request = new SoapObject("urn:RouterBoxMobile","AtualizarCadastroClientes");

        SoapObject chaveIntegracao = new SoapObject("urn:RouterBoxMobile","Autenticacao");
        chaveIntegracao.addProperty("ChaveIntegracao",chaveDeIntegracao);
        request.addProperty("Autenticacao", chaveIntegracao);


        SoapObject dadosAtualizadosClientes = new SoapObject("urn:RouterBoxMobile", "DadosAtualizadosClientes");
        dadosAtualizadosClientes.addProperty("CodigoCliente",dados.codigo);
        dadosAtualizadosClientes.addProperty("Usuario",dados.usuario);
        dadosAtualizadosClientes.addProperty("Senha",dados.senha);
        dadosAtualizadosClientes.addProperty("CEP",dados.cep);
        dadosAtualizadosClientes.addProperty("Bairro",dados.bairro);
        dadosAtualizadosClientes.addProperty("Endereco",dados.endereco);
        dadosAtualizadosClientes.addProperty("Numero",dados.numero);
        dadosAtualizadosClientes.addProperty("Complemento",dados.complemento);
        dadosAtualizadosClientes.addProperty("TelComercial",dados.foneComercial);
        dadosAtualizadosClientes.addProperty("TelResidencial",dados.foneResidencial);
        dadosAtualizadosClientes.addProperty("TelCelular",dados.foneCelular);
        dadosAtualizadosClientes.addProperty("Email",dados.email);

        request.addProperty("DadosAtualizadosClientes",dadosAtualizadosClientes);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransportSE = new HttpTransportSE(URL_WEBSERVICE);
        httpTransportSE.debug=true;


        try {
            httpTransportSE.call("",envelope);
            Log.d("Response",httpTransportSE.requestDump.toString());


            SoapObject  response = (SoapObject) envelope.getResponse();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
       return null;
    }