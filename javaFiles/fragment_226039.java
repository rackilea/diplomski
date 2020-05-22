static final  String BEGIN_QUERY = "SELECT c.contratoId, c.contrato, c.classificacao, c.responsavel, c.uf, c.sigla, "
        + "c.statusContrato, c.fornecedor, c.site, c.login, c.senha, c.telefone, c.cnpj, c.codigoFornecedor, c.hidrometro, " // here
        + "c.nome, c.endereco, c.despesa, c.descricao, c.mp, c.status, c.estadoLancamento, " // here
        + "h.historicoId, h.dataCobranca, h.dataVencimento, h.dataEmissao, h.dataLancamento, h.dataCompensacao, h.dataAtualizacao, h.docPgt, h.docCompensacao " // here 
        + "FROM Contrato c, Historico h " // here
        + "WHERE c.contratoId = h.contratoId " // and here
        + "AND 1=1";